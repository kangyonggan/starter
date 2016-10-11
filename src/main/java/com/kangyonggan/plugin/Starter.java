package com.kangyonggan.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

import java.lang.reflect.Method;

/**
 * main方法启动器
 *
 * @author kangyonggan
 * @since 16/10/11
 */
@Mojo(name = "starter")
public class Starter extends AbstractMojo {

    @Parameter
    private String clazz;

    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            Class mainClass = Class.forName(clazz);
            Object mainObject = mainClass.newInstance();
            Method mainMethod = mainClass.getDeclaredMethod("main", String[].class);
            mainMethod.invoke(mainObject, (Object) new String[]{});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
