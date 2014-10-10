package state;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 
 * Deep copy implementation that is used in GridFactory to set neighbors.
 * 
 * @author Steve
 *
 */
public class DeepCopy {
    public static Object deepCopy(Object originalObject) {
        Object newObject = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(originalObject);
            objectOutputStream.flush();
            objectOutputStream.close();

            ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
            newObject = inputStream.readObject();
        }
        catch(IOException ioE) {
            ioE.printStackTrace();
        }
        catch(ClassNotFoundException notFoundE) {
            notFoundE.printStackTrace();
        }
        return newObject;
    }

}