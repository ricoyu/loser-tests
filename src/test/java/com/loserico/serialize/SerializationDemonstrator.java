package com.loserico.serialize;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * https://www.javaworld.com/article/2097430/java-se/serializing-java-objects-with-non-serializable-attributes.html
 * Simple serialization/deserialization demonstrator.
 * 
 * @author Dustin
 */
public class SerializationDemonstrator {
	
	private static final Logger logger = LoggerFactory.getLogger(SerializationDemonstrator.class);
	
	/**
	 * Serialize the provided object to the file of the provided name.
	 * 
	 * @param objectToSerialize Object that is to be serialized to file; 
	 * 			it is best that this object have an individually overridden 
	 * 			toString() implementation as that is used by this method for writing our status.
	 * @param  fileName Name of file to which object is to be serialized.
	 * @throws IllegalArgumentException Thrown if either provided parameter is null.
	 */
	public static <T> void serialize(final T objectToSerialize, final String fileName) {
		if (fileName == null) {
			throw new IllegalArgumentException("Name of file to which to serialize object to cannot be null.");
		}
		if (objectToSerialize == null) {
			throw new IllegalArgumentException("Object to be serialized cannot be null.");
		}
		try (FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(objectToSerialize);
		} catch (IOException e) {
			logger.error("", e);
		}
	}

	/**
	 * 
	 * @param objectToSerialize
	 * @return
	 */
	public static <T> byte[] serialize(final T objectToSerialize) {
		if (objectToSerialize == null) {
			throw new IllegalArgumentException("Object to be serialized cannot be null.");
		}
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ObjectOutputStream oos = new ObjectOutputStream(baos)) {
			oos.writeObject(objectToSerialize);
			return baos.toByteArray();
		} catch (IOException e) {
			logger.error("", e);
		}
		return new byte[0];
	}

	/**
	 * Provides an object deserialized from the file indicated by the provided file
	 * name.
	 * 
	 * @param <T> Type of object to be deserialized.
	 * @param fileToDeserialize Name of file from which object is to be deserialized.
	 * @param classBeingDeserialized Class definition of object to be deserialized
	 *            from the file of the provided name/path; it is recommended that this
	 *            class define its own toString() implementation as that will be used
	 *            in this method's status output.
	 * @return Object deserialized from provided filename as an instance of the
	 *         provided class; may be null if something goes wrong with
	 *         deserialization.
	 * @throws IllegalArgumentException Thrown if either provided parameter is null.
	 */
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(final String fileToDeserialize, final Class<T> classBeingDeserialized) {
		if (fileToDeserialize == null) {
			throw new IllegalArgumentException("Cannot deserialize from a null filename.");
		}
		if (classBeingDeserialized == null) {
			throw new IllegalArgumentException("Type of class to be deserialized cannot be null.");
		}
		T objectOut = null;
		try (FileInputStream fis = new FileInputStream(fileToDeserialize);
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			objectOut = (T) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			logger.error("", e);
		}
		return objectOut;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T deserialize(final byte[] bytes, final Class<T> classBeingDeserialized) {
		if (classBeingDeserialized == null) {
			throw new IllegalArgumentException("Type of class to be deserialized cannot be null.");
		}
		T objectOut = null;
		try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais)) {
			objectOut = (T) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			logger.error("", e);
		}
		return objectOut;
	}
}