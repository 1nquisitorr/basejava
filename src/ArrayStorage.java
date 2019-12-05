/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private static int ARRAY_SIZE = 10000;
    private Resume[] storage = new Resume[ARRAY_SIZE];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size < ARRAY_SIZE) {
            storage[size] = r;
            size++;
        }

    }


    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < size; j++) {
                    storage[j] = j + 1 != size ? storage[j + 1] : null;
                }
                size--;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] resumes() {
        Resume[] getAll = new Resume[size];
        if (size() >= 0) System.arraycopy(storage, 0, getAll, 0, size);
        return getAll;
    }

    int size() {
        return size;
    }

}