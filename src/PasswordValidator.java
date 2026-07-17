// ดูโจทย์ spec และวิธีทำใน README.md
public class PasswordValidator {

    static final int MIN_LEN = 8;
    static final int MAX_LEN = 20;

    static boolean validate(String pw) {
        // TODO: implement ตาม spec ใน README.md (R1-R6)
        if (pw == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (pw.length() < MIN_LEN || pw.length() > MAX_LEN) {
            return false;
        }
        // TODO: Implement checks for uppercase, lowercase,digit and Space requirements
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSpace = false;
        
        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (Character.isSpaceChar(c)) { 
                hasSpace = true;
            }
        }
        if (hasSpace) {
            return false; // R6: No whitespace allowed
        }
        if (!hasUppercase || !hasLowercase || !hasDigit ) {
            return false;
        }
        if (pw.isEmpty()) {
            return false; // Additional boundary check for empty password
        }
        if (pw.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            return true; // Allow special characters
        }
        return hasUppercase && hasLowercase && hasDigit && !hasSpace; // R3, R4, R5: Must have uppercase, lowercase, and digit
    }
}
