package ua.patlan.lab2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

public interface DAO {
    public Session openCurrentSession();

    public Session openCurrentSessionWithTransaction();

    public void closeCurrentSession();

    public void closeCurrentSessionWithTransaction();

    public Session getCurrentSession();

    public void setCurrentSession(Session currentSession);

    public Transaction getCurrentTransaction();

    public void setCurrentTransaction(Transaction currentTransaction);
}
