package weka;

import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Test {

	public static void main(String[] a) {

		try {
			BufferedReader reader = new BufferedReader(new FileReader("D:/wekaworkspace/weather.arff"));
			Instances data;
			data = new Instances(reader);
			reader.close();

			// setting class attribute
			data.setClassIndex(data.numAttributes() - 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
