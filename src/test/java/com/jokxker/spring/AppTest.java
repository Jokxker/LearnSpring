package com.jokxker.spring;

import com.jokxker.spring.introduction.MyConfig;
import com.jokxker.spring.introduction.MyConfig2;
import com.jokxker.spring.introduction.Person;
import com.jokxker.spring.introduction.Pet;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void inversionOfControl() {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Pet pet = context.getBean("myPet", Pet.class);
            pet.say();
            System.out.println("Inversion of control to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void dependencyInjectionToConstructor() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Person person = context.getBean("myPerson", Person.class);
            person.callYourPet();
            System.out.println("Dependency injection to constructor to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void dependencyInjectionToSet() {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Person person = context.getBean("myPerson2", Person.class);
            person.callYourPet();
            System.out.println("Dependency injection to set to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void dependencyInjectionToVariable() {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Person person = context.getBean("myPerson3", Person.class);
            person.callYourPet();
            System.out.println(person.getName() + " " + person.getAge());
            System.out.println("Dependency injection to variable to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void scopeSingleton() {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Pet pet1 = context.getBean("myPet", Pet.class);
            Pet pet2 = context.getBean("myPet", Pet.class);
            assertSame(pet1, pet2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void scopePrototype() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContext.xml")) {
            Pet pet1 = context.getBean("myPet2", Pet.class);
            Pet pet2 = context.getBean("myPet2", Pet.class);
            Assert.assertNotSame(pet1, pet2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void annotationComponent() {
        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAnnotations.xml")) {
            Pet petDog = context.getBean("dogBean", Pet.class);
            petDog.say();
            System.out.println("Annotation component to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void annotationAutowired() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContextAnnotations.xml")) {
            Person person = context.getBean("personBean", Person.class);
            person.callYourPet();
            System.out.println("Annotation autowired to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void annotationValue() {
        try(ClassPathXmlApplicationContext context =
                    new ClassPathXmlApplicationContext("applicationContextAnnotations.xml")) {
            Person person = context.getBean("personBean", Person.class);
            System.out.println(person.getName() + " " + person.getAge());
            System.out.println("Annotation value to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void configWithJava() {
        try(AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig.class)) {
            Person person = context.getBean("personBean", Person.class);
            person.callYourPet();
            System.out.println(person.getName() + " " + person.getAge());
            System.out.println("Config with Java to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void configWithJava2() {
        try(AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MyConfig2.class)) {
            Person person = context.getBean("personBean", Person.class);
            person.callYourPet();
            System.out.println(person.getName() + " " + person.getAge());
            System.out.println("Config with Java 2 to worked");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}