package sn.sa.devweb.domain;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Transaction.class)
public abstract class Transaction_ {

	public static volatile SingularAttribute<Transaction, Double> commRec;
	public static volatile SingularAttribute<Transaction, Double> comm;
	public static volatile SingularAttribute<Transaction, Double> codeTransaction;
	public static volatile SingularAttribute<Transaction, Double> commSys;
	public static volatile SingularAttribute<Transaction, Double> montant;
	public static volatile SingularAttribute<Transaction, Double> taxe;
	public static volatile SingularAttribute<Transaction, User> idUserExp;
	public static volatile SingularAttribute<Transaction, User> idUserRec;
	public static volatile SingularAttribute<Transaction, LocalDate> dateEnvoie;
	public static volatile SingularAttribute<Transaction, Client> idDest;
	public static volatile SingularAttribute<Transaction, Double> commExp;
	public static volatile SingularAttribute<Transaction, Client> idExp;
	public static volatile SingularAttribute<Transaction, Long> id;
	public static volatile SingularAttribute<Transaction, LocalDate> dateRetrait;
	public static volatile SingularAttribute<Transaction, String> status;

	public static final String COMM_REC = "commRec";
	public static final String COMM = "comm";
	public static final String CODE_TRANSACTION = "codeTransaction";
	public static final String COMM_SYS = "commSys";
	public static final String MONTANT = "montant";
	public static final String TAXE = "taxe";
	public static final String ID_USER_EXP = "idUserExp";
	public static final String ID_USER_REC = "idUserRec";
	public static final String DATE_ENVOIE = "dateEnvoie";
	public static final String ID_DEST = "idDest";
	public static final String COMM_EXP = "commExp";
	public static final String ID_EXP = "idExp";
	public static final String ID = "id";
	public static final String DATE_RETRAIT = "dateRetrait";
	public static final String STATUS = "status";

}

