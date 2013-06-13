package ch.bfh.bti7081.s2013.blue.utils;

import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import ch.bfh.bti7081.s2013.blue.entities.MedicalDrug;
import ch.bfh.bti7081.s2013.blue.entities.Patient;
import ch.bfh.bti7081.s2013.blue.entities.Prescription;
import ch.bfh.bti7081.s2013.blue.entities.PrescriptionItem;

public class GenerateTestData {
    

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("mhc-pms");
        EntityManager em = factory.createEntityManager();
        
        em.getTransaction().begin();
        
        em.createQuery("DELETE FROM PrescriptionItem").executeUpdate();
        em.createQuery("DELETE FROM Report").executeUpdate();
        em.createQuery("DELETE FROM Prescription").executeUpdate();
        em.createQuery("DELETE FROM Patient").executeUpdate();
        
        String[] firstNames = {"Fritz", "Ueli", "Peter", "Tobias", "Marcel"};
        String[] lastNames = {"Berger", "Brügger", "Müller"};
        String[] drugs = {"Fluconax 200 mg, Kapseln", "Dafalgan, Brausetabletten 500 mg",
                "Azaimun 50 mg, Tabletten", "Lyrica 150 mg, Kapseln", "Mimpara 60 mg, Filmtabletten"};
        String doctor = "Gregory House";
        Date prescriptionStart = getDate(2013, 0, 1);
        Date prescriptionEnd = getDate(2013, 11, 31);
        
        TypedQuery<MedicalDrug> query = em.createQuery("SELECT drug FROM MedicalDrug drug WHERE drug.name IN :drugs", MedicalDrug.class);
        query.setParameter("drugs", Arrays.asList(drugs));
        List<MedicalDrug> medicalDrugs = query.getResultList();
        
        int[] amount = {0, 0, 1, 1, 2};
        
        for (String firstName : firstNames) {
            for (String lastName : lastNames) {
                Patient patient = new Patient();
                patient.setFirstName(firstName);
                patient.setLastName(lastName);
                
                Random r = new Random();
                patient.setBirthday(getDate(1930 + r.nextInt(80), r.nextInt(12), 1 + r.nextInt(28)));
                em.persist(patient);
                
                Prescription prescription = new Prescription();
                prescription.setDate(prescriptionStart);
                prescription.setDoctor(doctor);
                prescription.setPatient(patient);
                em.persist(prescription);
                
                int count = 1 + r.nextInt(4);
                Collections.shuffle(medicalDrugs);
                for (int i = 0; i < count; i++) {
                    PrescriptionItem item = new PrescriptionItem();
                    item.setStartDate(prescriptionStart);
                    item.setEndDate(prescriptionEnd);
                    item.setPrescription(prescription);
                    item.setMedicalDrug(medicalDrugs.get(i));
                    item.setMorning(amount[r.nextInt(5)]);
                    item.setNoon(amount[r.nextInt(5)]);
                    item.setEvening(amount[r.nextInt(5)]);
                    item.setNight(amount[r.nextInt(5)]);
                    em.persist(item);
                }
            }
        }
        em.getTransaction().commit();
        em.close();
    }
    
    private static Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH,  month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return new Date(calendar.getTime().getTime());
    }
    

}



