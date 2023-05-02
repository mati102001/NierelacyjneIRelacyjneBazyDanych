package model;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SportField.class)
public abstract class SportField_ {

	public static volatile SingularAttribute<SportField, Boolean> archived;
	public static volatile SingularAttribute<SportField, String> surface;
	public static volatile SingularAttribute<SportField, String> sportFieldId;
	public static volatile SingularAttribute<SportField, Long> id;
	public static volatile SingularAttribute<SportField, String> discipline;

	public static final String ARCHIVED = "archived";
	public static final String SURFACE = "surface";
	public static final String SPORT_FIELD_ID = "sportFieldId";
	public static final String ID = "id";
	public static final String DISCIPLINE = "discipline";

}

