package asm2.a2_1901040247;

import java.util.ArrayList;

public class EnrolmentManager {
    ArrayList<Enrolment> enrolments = new ArrayList<>();

    public EnrolmentManager() {
    }

    public void addEnrolment(Enrolment enrolment) {
        enrolments.add(enrolment);
    }

    public Enrolment getEnrolment(Student student, Module module) {
        for (Enrolment enrolment : enrolments) {
            if ((enrolment.getStudent() == student) && (enrolment.getModule()
            == module)) return enrolment;
        }
        return null;
    }

    public void setMarks(Student student, Module module, double internalMark,
                         double examMark) {
        Enrolment enrolment = getEnrolment(student, module);
        enrolment.setInternalMark(internalMark);
        enrolment.setExamMark(examMark);
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (Enrolment enrolment : enrolments) {
            index++;
            sb.append("Enrolment ").append(index).append(" of ").append(enrolment.getStudent().
                    toString()).append(" with ").append(enrolment.getModule().toString()).append("\n");
        }
        return sb.toString();
    }

    public String reportAssessment() {
        StringBuilder sb = new StringBuilder();
        for (Enrolment enrolment : enrolments) {
            sb.append(enrolment.toString()).append("\n");
        }
        return sb.toString();
    }

    public void sort() {
        if (enrolments.size() > 1) {
            ArrayList<Enrolment> sort = new ArrayList<>();
            Enrolment max = enrolments.get(0);

            for (int i = 1; i < enrolments.size(); i++) {
                if (Integer.parseInt(enrolments.get(i).getStudent().getId().
                        substring(2)) > Integer.parseInt(max.
                        getStudent().getId().substring(2))) {
                    max = enrolments.get(i);
                }
            }

            int idCount = Integer.parseInt(max.getStudent().getId().
                    substring(2));
            sort.add(max);
            enrolments.remove(max);

            while (enrolments.size() > 0) {
                for (int i = 0; i < enrolments.size(); i++) {
                    if (Integer.parseInt(enrolments.get(i).getStudent().
                            getId().substring(2)) == idCount) {
                        sort.add(enrolments.get(i));
                        enrolments.remove(i);
                        break;
                    }
                    if (i == enrolments.size()-1) idCount--;
                }
            }

            enrolments = sort;
        }
    }
}
