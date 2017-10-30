/*
 * Copyright (C) 2015 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 010 10.01.2015
 */
package by.academy.it.aspects_xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.academy.it.aspects_xml.TaskService;

public class AspectXmlLoader {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspects_xml.xml");
        TaskService bean = (TaskService) context.getBean("taskService");
        bean.performJob();
//        bean.performJob("Spring");
        bean.performJob("Spring", 1000000);
        /*try {
            bean.performExceptionJob();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        ((ClassPathXmlApplicationContext) context).close();
    }
}
