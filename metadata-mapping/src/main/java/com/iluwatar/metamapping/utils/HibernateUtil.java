package com.iluwatar.metamapping.utils;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Manage hibernate.
 */
@Slf4j
public class HibernateUtil {

  private static final SessionFactory sessionFactory = buildSessionFactory();

  /**
   * Hide constructor.
   */
  private HibernateUtil() {}

  /**
   * Build session factory.
   * @return session factory
   */
  private static SessionFactory buildSessionFactory() {
    // Create the SessionFactory from hibernate.cfg.xml
    return new Configuration().configure().buildSessionFactory();
  }

  /**
   * Get session factory.
   * @return session factory
   */
  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }

  /**
   * Close session factory.
   */
  public static void shutdown() {
    // Close caches and connection pools
    getSessionFactory().close();
  }

}