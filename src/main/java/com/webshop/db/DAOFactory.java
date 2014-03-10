package com.webshop.db;

/**
 * Created by Oleg on 08.03.14.
 */
public abstract class DAOFactory {
    public static final int QL = 1;
    public static final int HIBERNATE = 2;

    public abstract ClientDAO getClientDAO();
    public abstract ItemDAO getItemDAO();
    public abstract OrderDAO getOrderDAO();

    public static DAOFactory getDAOFactory(int factoryType) {
        switch (factoryType) {
            case QL:
                return new QlDAOFactory();
            case HIBERNATE:
                return new HnDAOFactory();
            default:
                return null;
        }
    }
}
