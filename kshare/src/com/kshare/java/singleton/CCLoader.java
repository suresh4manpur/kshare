package com.kshare.java.singleton;


import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
 
/**
 * Our Custom Class Loader to load the classes. Any class in the com.journaldev
 * package will be loaded using this ClassLoader. For other classes, it will
 * delegate the request to its Parent ClassLoader.
 *
 */
public class CCLoader extends ClassLoader {
    private ChildClassLoader childClassLoader;
    public CCLoader(List<URL> classpath)
    {
        super(Thread.currentThread().getContextClassLoader());
        URL[] urls = classpath.toArray(new URL[classpath.size()]);
        childClassLoader = new ChildClassLoader( urls, new DetectClass(this.getParent()) );
    }
    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException
    {
        try
        {
            return childClassLoader.findClass(name);
        }
        catch( ClassNotFoundException e )
        {
            return super.loadClass(name, resolve);
        }
    }
    private static class ChildClassLoader extends URLClassLoader
    {
        private DetectClass realParent;
        public ChildClassLoader( URL[] urls, DetectClass realParent )
        {
            super(urls, null);
            this.realParent = realParent;
        }
        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException
        {
            try
            {
            Class<?> loaded = super.findLoadedClass(name);
                if( loaded != null )
                    return loaded;
                return super.findClass(name);
            }
            catch( ClassNotFoundException e )
            {
                return realParent.loadClass(name);
            }
        }
    }
    private static class DetectClass extends ClassLoader
    {
        public DetectClass(ClassLoader parent)
        {
            super(parent);
        }
        @Override
        public Class<?> findClass(String name) throws ClassNotFoundException
        {
            return super.findClass(name);
        }
     }
    }

