/**
 * Array based storage for Resumes
 */

public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }

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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(uuid)) {
                    storage[i] = null;
                    size--;
                }
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
        return size;
    }
}
