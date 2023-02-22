package com.hz.bean;

import com.hz.anno.Bean;
import com.hz.anno.Di;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class AnnotationApplicationContext implements ApplicationContext {
    Map<Class, Object> beanFactory = new HashMap<>();
    private String rootPath;

    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    //设置包的扫描规则
    public AnnotationApplicationContext(String path) {
        //1 replace . to \
        path = path.replaceAll("\\.", "\\");
        //2 get package absolute path
        try {
            Enumeration<URL> resources = Thread.currentThread().getContextClassLoader().getResources(path);
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "UTF-8");
                //package scan

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //3 属性注入
        loadDi();
    }

    private void loadDi() {
        //init classes are all in beanFactory
        //1 loop beanFactory
        for (Map.Entry<Class, Object> entrySet : beanFactory.entrySet()) {
            Object object = entrySet.getValue();
            Class<?> clazz = object.getClass();
            //2 get all map bean,to get all values of bean
            Field[] declaredFields = clazz.getDeclaredFields();
            //3 loop each bean values array,to get each value
            for(Field field :declaredFields) {
                //4 judge has @Di interface
                Di annotation = field.getAnnotation(Di.class);
                if(annotation!=null) {
                    field.setAccessible(true);
                    try {
                        field.set(object,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }



        //5 if true,setting bean
    }


    private void loadBean(File file) throws Exception {
        //1 judge if folder
        if (file.isDirectory()) {
            //2 get file all info
            File[] childrenFiles = file.listFiles();
            //3 if folder is empty, return
            if (childrenFiles == null || childrenFiles.length == 0) {
                return;
            }
            //4 if folder is not empty, while all folder info
            for (File child : childrenFiles) {
                //4.1 get each file info,continue judge while
                if (child.isDirectory()) {
                    loadBean(child);
                } else {
                    //4.2 if file is not folder
                    //4.3 get package path and class name-> string substring
                    String pathWithClass = child.getAbsolutePath().substring(rootPath.length() - 1);
                    //4.4 if current file is .class file
                    if (pathWithClass.contains(".class")) {
                        //4.5 if ture ,replace \ to . and remove .class->com.hz.spring6.service.UserServiceImpl
                        String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
                        //4.6 if class has interface. If true , init bean
                        //4.6.1 get class
                        //4.6.2 if class is not interface
                        Class<?> clazz = Class.forName(allName);
                        if (!clazz.isInterface()) {
                            //4.6.3 judge have interface
                            Bean annotation = clazz.getAnnotation(Bean.class);
                            if (annotation != null) {
                                //4.6.4 init bean
                                Object instance = clazz.getDeclaredConstructor().newInstance();
                                //4.7 put init Bean to map
                                //4.7.1 if current class has interface,use interface as key
                                if (clazz.getInterfaces().length > 0) {
                                    beanFactory.put(clazz.getInterfaces()[0], instance);
                                } else {
                                    beanFactory.put(clazz, instance);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
