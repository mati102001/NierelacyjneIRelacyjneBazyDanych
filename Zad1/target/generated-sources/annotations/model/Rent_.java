package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Rent.class)
public abstract class Rent_ {

	public static volatile SingularAttribute<Rent, LocalDate> date;
	public static volatile SingularAttribute<Rent, Boolean> archived;
	public static volatile SingularAttribute<Rent, SportField> field;
	public static volatile SingularAttribute<Rent, Client> client;
	public static volatile SingularAttribute<Rent, Long> id;
	public static volatile SingularAttribute<Rent, LocalTime> beginTime;
	public static volatile SingularAttribute<Rent, LocalTime> endTime;
	public static volatile SingularAttribute<Rent, String> rentId;

	public static final String DATE = "date";
	public static final String ARCHIVED = "archived";
	public static final String FIELD = "field";
	public static final String CLIENT = "client";
	public static final String ID = "id";
	public static final String BEGIN_TIME = "beginTime";
	public static final String END_TIME = "endTime";
	public static final String RENT_ID = "rentId";

}

