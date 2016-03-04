/**
 * Created by sumand on 03/03/16.
 */
public enum Gender {
    MALE {
        @Override
        public String toString() {
            return "Mr";
        }
    },
    FEMALE {
        @Override
        public String toString() {
            return "Ms";
        }
    }
}
