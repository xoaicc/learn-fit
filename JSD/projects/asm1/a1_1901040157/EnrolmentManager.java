package asm1.a1_1901040157;

import java.util.ArrayList;

public class EnrolmentManager {
    ArrayList<Enrolment> enrols = new ArrayList<>();

    public EnrolmentManager() {
    }

    public void addEnrolment(Enrolment enrolment) {
        enrols.add(enrolment);
    }

    public Enrolment getEnrolment(Student student, Module module) {
        for (Enrolment e : enrols) {
            if ((e.getStudent() == student) && (e.getModule() == module)) {
                return e;
            }
        }
        return null;
    }

    public void setMarks(Student student, Module module, double internalMark, double examMark) {
        Enrolment enrol = getEnrolment(student, module);
        enrol.setInternalMark(internalMark);
        enrol.setExamMark(examMark);
    }

    public String report() {
        StringBuilder stb = new StringBuilder();
        int i = 0;

        for (Enrolment e : enrols) {
            stb.append("Enrolment num ").append(++i).append(": ").append(e.getStudent().toString()).append(", ").append(e.getModule().toString()).append("\n");
        }

        return stb.toString();
    }

    public String reportAssessment() {
        StringBuilder stb = new StringBuilder();
        for (Enrolment e : enrols) {
            stb.append(e.toString()).append("\n");
        }
        return stb.toString();
    }

    public void sort() {
        if (enrols.size() >= 2) {
            ArrayList<Enrolment> nEnrols = new ArrayList<>();
            Enrolment maxEnrol = enrols.get(0);

            for (int i = 1; i < enrols.size(); i++) {
                if (Integer.parseInt(enrols.get(i).getStudent().getId().substring(1)) > Integer.parseInt(maxEnrol.getStudent().getId().substring(1))) {
                    maxEnrol = enrols.get(i);
                }
            }

            int year = Integer.parseInt(maxEnrol.getStudent().getId().substring(1));
            nEnrols.add(maxEnrol);
            enrols.remove(maxEnrol);

            while (enrols.size() > 0) {
                for (int i = 0; i < enrols.size(); i++) {
                    if (Integer.parseInt(enrols.get(i).getStudent().getId().substring(1)) == year) {
                        nEnrols.add(enrols.get(i));
                        enrols.remove(i);
                        break;
                    }

                    if ((i+1) == enrols.size()) {
                        year--;
                    }
                }
            }

            enrols = nEnrols;
        }
    }
}
