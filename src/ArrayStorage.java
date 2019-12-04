/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private static int ARRAYSIZE = 10000;
    private Resume[] storage = new Resume[ARRAYSIZE];
    int size = 0;

    void clear() {
        for (int i = 0; i < ARRAYSIZE; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        if (size < ARRAYSIZE) {
            storage[size] = r;
            size++;
        }

    }


    Resume get(String uuid) {
        Resume found = null;
        for (Resume resume : storage) {
            if (resume != null) {
                if (resume.uuid.equals(uuid)) {
                    found = resume;
                    break;
                }
            }
        }
        return found;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < size; j++) {
                    storage[j] = j < size ? storage[j + 1] : null;
                }
                size--;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] getAll = new Resume[size()];
        if (size() >= 0) System.arraycopy(storage, 0, getAll, 0, size);
        return getAll;
    }

    int size() {
        return size;
    }
}