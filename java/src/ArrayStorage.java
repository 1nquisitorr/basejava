import java.util.Arrays;

/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[100000];

    void clear() {
        Arrays.fill(storage, null);
    }


    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }

        }
    }

    Resume get(String uuid) {
        Resume found = null;
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) {
                found = resume;
                break;
            }

        }
        return found;
    }

    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid))
                    storage[i] = null;
            }

        }

        for (int i = 0; i < storage.length - 2; i++) {

            if (storage[i] == null) {
                storage[i] = storage[i + 1];
                storage[i + 1] = storage[i + 2];
                storage[i + 2] = null;

            }
        }

    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {

        Resume[] getAll = new Resume[size()];
        if (size() >= 0) System.arraycopy(storage, 0, getAll, 0, size());
        return getAll;
    }

    int size() {
        int length = 0;
        if (storage[0] == null)
            return length;

        for (int i = 1; i < storage.length; i++) {
            if (storage[i] == null)
                return i;
        }

        return length;
    }


}
