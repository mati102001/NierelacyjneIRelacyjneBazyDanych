package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PrivatePerson.class)
public abstract class PrivatePerson_ extends model.Client_ {

	public static volatile SingularAttribute<PrivatePerson, String> firstName;
	public static volatile SingularAttribute<PrivatePerson, String> lastName;

	public static final String FIRST_NAME = "firstName";
	public static final String LAST_NAME = "lastName";

}

