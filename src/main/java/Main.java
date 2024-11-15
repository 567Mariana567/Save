import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Save {
}

class Serializer {
    public static void serialize(Object obj, String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(obj);
        }
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return ois.readObject();
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        // ...
        Data deserializedData = (Data) Serializer.deserialize("data.ser");
        System.out.println(deserializedData.getName());
        System.out.println(deserializedData.age);
    }
}
