/*
 * Copyright (C) 2014 GHX, Inc.
 *  Louisville, Colorado, USA.
 *  All rights reserved.
 *
 *  Warning: Unauthorized reproduction or distribution of this program, or
 *  any portion of it, may result in severe civil and criminal penalties,
 *  and will be prosecuted to the maximum extent possible under the law.
 *
 *  Created on 001 01.08.2014
 */
package by.academy.it.aspects;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.academy.it.aspects.TaskService;

public class AspectLoader {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aspects.xml");
        TaskService bean = (TaskService) context.getBean("taskService");
        bean.performJob("Spring");
        bean.performJob();
        bean.performJobAround();
        ((ClassPathXmlApplicationContext) context).close();
    }
}
