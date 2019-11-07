package fr.formation.inti.utils;

public class Constants {
	public static final String SELECT_EMPLOYEE = "SELECT EMP_ID,FIRST_NAME,LAST_NAME,START_DATE FROM bd.employee;";
	public static final String LAST_RDV ="SELECT idfiche, nom, prenom, date_rdv FROM bdd.fiche INNER JOIN ( SELECT pId, MAX(date_rdv) as date_rdv FROM fiche group by pId ) as max USING (pId, date_rdv) join bdd.patient on bdd.patient.pId = bdd.fiche.pId order by date_rdv desc";
}
