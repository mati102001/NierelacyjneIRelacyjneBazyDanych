package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, Integer> numberOfPlayers;
	public static volatile SingularAttribute<Client, Boolean> archived;
	public static volatile SingularAttribute<Client, String> phoneNumber;
	public static volatile SingularAttribute<Client, String> clientId;
	public static volatile SingularAttribute<Client, Long> id;

	public static final String NUMBER_OF_PLAYERS = "numberOfPlayers";
	public static final String ARCHIVED = "archived";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String CLIENT_ID = "clientId";
	public static final String ID = "id";

}

