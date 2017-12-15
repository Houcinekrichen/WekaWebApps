package weka;

import weka.core.Instances;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.converters.ArffLoader;
import weka.core.converters.CSVSaver;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.*;

public class Test2 {

	public static void main(String ar[]) {

		try {
			// load ARFF
			ArffLoader loader = new ArffLoader();
			loader.setSource(new File("D:/wekaworkspace/zoo.arff"));
			Instances data = loader.getDataSet();
			// get instances object
			// save CSV
			CSVSaver saver = new CSVSaver();
			saver.setInstances(data);// set the dataset to convert
			// and save as CSV

			int index1 = data.numAttributes() - 1;
			// saver.setFile(new File("D:/wekaworkspace/data.csv"));
			// saver.writeBatch();

			// load dataset
			// set class index to the last attribute
			data.setClassIndex(index1);

			Instances test = new Instances(new BufferedReader(new FileReader("D:/wekaworkspace/aa.arff")));
			test.setClassIndex(index1);

			Classifier j = new J48();
			j.buildClassifier(data);

			NaiveBayes nb = new NaiveBayes();
			nb.buildClassifier(data);

			Vector<String> a = new Vector<>();
			Class c = new Class();

			for (int i = 0; i < test.numInstances(); i++) {

				double index = nb.classifyInstance(test.instance(i));
				String className = data.attribute(index1).value((int) index);
				System.out.println(className);
				a.add(className);
			}

		
			// create and build the classifier!

			// evaluate theclassifier
			// Evaluation eval = new Evaluation(data);

			// System.out.println(data);
			System.out.println(nb);

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
