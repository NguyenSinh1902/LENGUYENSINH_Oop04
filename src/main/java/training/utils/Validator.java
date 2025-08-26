package training.utils;

import training.entities.Course;
import java.util.ArrayList;

public class Validator {
    private static final String CODE_PATTERN = "^RA\\d{3}$";
    private static final String[] VALID_FLAGS = {"optional", "prerequisite", "N/A"};

    public static boolean validateCode(String code) {
        return code != null && code.matches(CODE_PATTERN);
    }

    // Check trung
    public static boolean isDuplicatedCode(String code, ArrayList<Course> courses) {
        for (Course c : courses) {
            if (c.getCode().equalsIgnoreCase(code)) {
                return true;
            }
        }
        return false;
    }

    // Validate status
    public static boolean validateStatus(boolean status) {
        return status == true || status == false; // luôn hợp lệ, nhưng viết để rõ
    }

    // Validate flag
    public static boolean validateFlag(String flag) {
        for (String valid : VALID_FLAGS) {
            if (valid.equalsIgnoreCase(flag)) {
                return true;
            }
        }
        return false;
    }

    // Validate duration
    public static boolean validateDuration(short duration) {
        return duration > 0;
    }
}
