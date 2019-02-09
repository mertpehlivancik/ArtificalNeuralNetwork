package wkproject;

import weka.core.Instances;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
//import java.util.Random;
import weka.classifiers.trees.J48;
import weka.classifiers.rules.JRip;
import weka.classifiers.functions.SMO;
import weka.classifiers.functions.VotedPerceptron;
import weka.classifiers.trees.RandomForest;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.meta.AdaBoostM1;
import weka.classifiers.meta.ClassificationViaRegression;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.bayes.BayesNet;
import java.io.File;
import jxl.*;
import jxl.format.Colour;
import jxl.write.*;
import jxl.write.Number;

public class wkproject {
	public static int xxx = 0;
	public static List<Integer> myUsers = Arrays.asList(10, 12, 96, 81, 83, 41, 80, 92, 73, 29, 34, 84, 44, 69, 13, 77,
			15, 75, 65, 27);

	//////////////////////////////////////// DEVICESPAN
	//////////////////////////////////////// //////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////////////////
	public static void myMethod_Device_Train(int xxx) throws Exception {
		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TRAIN_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\devTrain\\").append("device")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));

					// reader = new BufferedReader(new
					// FileReader("c:\\Neurall_Hw2_desk\\DeviceSpan\\Train\\Results\\"
					// + myUsers.get(i) + "_YES_DEVICE_TRAIN_R" + j + "V" + (k + 1) + ".arff"));

					traindata = new Instances(reader);
					reader.close();
					// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}
					Evaluation eval = new Evaluation(traindata);
					// eval.crossValidateModel(cls, traindata, 10, new Random(1));
					eval.evaluateModel(cls, traindata);

					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}
					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
																										// classified
																										// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN DEVICESPAN TRAIN");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

	public static void myMethod_Device_Test(int xxx) throws Exception {

		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\DEVICE_TEST_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\devTrain\\").append("device")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));
					traindata = new Instances(reader);
					reader.close();
					// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					String str2 = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\devTest\\").append("device")
									.append(myUsers.get(i)).append(c).append("tt").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str2));
					Instances testdata = new Instances(reader);
					reader.close();
					// setting class attribute
					testdata.setClassIndex(testdata.numAttributes() - 1);

					// train classifier

					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}

					// evaluate classifier and print some statistics
					Evaluation eval = new Evaluation(traindata);

					eval.evaluateModel(cls, testdata);
					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}

					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
																										// classified
																										// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN DEVICESPAN TEST");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

////////////////////////////////////////CELLSPAN //////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	public static void myMethod_Cell_Train(int xxx) throws Exception {
		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TRAIN_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}

			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\cellTrain\\").append("cell")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));

					traindata = new Instances(reader);
					reader.close();
					// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}
					Evaluation eval = new Evaluation(traindata);
					// eval.crossValidateModel(cls, traindata, 10, new Random(1));
					eval.evaluateModel(cls, traindata);

					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}
					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
																										// classified
																										// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN CELLSPAN TRAIN");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

	public static void myMethod_Cell_Test(int xxx) throws Exception {

		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CELL_TEST_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\cellTrain\\").append("cell")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));
					traindata = new Instances(reader);
					reader.close();
					// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					String str2 = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\cellTest\\").append("cell")
									.append(myUsers.get(i)).append(c).append("tt").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str2));
					Instances testdata = new Instances(reader);
					reader.close();
					// setting class attribute
					testdata.setClassIndex(testdata.numAttributes() - 1);

					// train classifier

					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}

					// evaluate classifier and print some statistics
					Evaluation eval = new Evaluation(traindata);

					eval.evaluateModel(cls, testdata);
					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}

					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
																										// classified
																										// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN CELLSPAN TEST");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

////////////////////////////////////////CALLSPAN //////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	public static void myMethod_Call_Train(int xxx) throws Exception {
		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TRAIN_BayesNet.xls"));
		}

		for (int k = 1; k < 7; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			if (k == 5) {
				c = "d";
			}
			if (k == 6) {
				c = "e";
			}

			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\callTrain\\").append("call")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));

					traindata = new Instances(reader);
					reader.close();
// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}
					Evaluation eval = new Evaluation(traindata);
// eval.crossValidateModel(cls, traindata, 10, new Random(1));
					eval.evaluateModel(cls, traindata);

					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}
					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
					// classified
					// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN CALLSPAN TRAIN");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

	public static void myMethod_Call_Test(int xxx) throws Exception {

		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\CALL_TEST_BayesNet.xls"));
		}

		for (int k = 1; k < 7; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			if (k == 5) {
				c = "d";
			}
			if (k == 6) {
				c = "e";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\callTrain\\").append("call")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));
					traindata = new Instances(reader);
					reader.close();
// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					String str2 = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\callTest\\").append("call")
									.append(myUsers.get(i)).append(c).append("tt").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str2));
					Instances testdata = new Instances(reader);
					reader.close();
// setting class attribute
					testdata.setClassIndex(testdata.numAttributes() - 1);

// train classifier

					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}

// evaluate classifier and print some statistics
					Evaluation eval = new Evaluation(traindata);

					eval.evaluateModel(cls, testdata);
					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}

					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
					// classified
					// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN CALLSPAN TEST");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

////////////////////////////////////////ACTIVITYSPAN
//////////////////////////////////////// //////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////
	public static void myMethod_Activity_Train(int xxx) throws Exception {
		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TRAIN_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\actTrain\\").append("act")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));

// reader = new BufferedReader(new
// FileReader("c:\\Neurall_Hw2_desk\\DeviceSpan\\Train\\Results\\"
// + myUsers.get(i) + "_YES_DEVICE_TRAIN_R" + j + "V" + (k + 1) + ".arff"));

					traindata = new Instances(reader);
					reader.close();
// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}
					Evaluation eval = new Evaluation(traindata);
// eval.crossValidateModel(cls, traindata, 10, new Random(1));
					eval.evaluateModel(cls, traindata);

					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}
					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
					// classified
					// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN ACTIVITY TRAIN");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

	public static void myMethod_Activity_Test(int xxx) throws Exception {

		BufferedReader reader;
		Instances traindata;
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;

		WritableFont arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font.setColour(Colour.RED);
		WritableCellFormat arial10format_USER = new WritableCellFormat(arial10font);
		arial10format_USER.setWrap(true);

		WritableFont arial10font_3 = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);

		WritableCellFormat arial10format_3 = new WritableCellFormat(arial10font_3);

		arial10format_3.setShrinkToFit(true);

		WritableFont arial10font_DETAIL = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false);
		arial10font_DETAIL.setColour(Colour.BLUE);
		WritableFont arial10format_DETAIL = new WritableFont(arial10font_DETAIL);

		NumberFormat fourdps = new NumberFormat("0.####");
		WritableCellFormat fourdpsFormat = new WritableCellFormat(arial10format_DETAIL, fourdps);
		fourdpsFormat.setWrap(true);

		int count1 = 0;
		int count2 = 0;
		if (xxx == 0) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_JRip.xls"));
		}
		if (xxx == 1) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_J48.xls"));
		}
		if (xxx == 2) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_SMO.xls"));
		}
		if (xxx == 3) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_VotedPerceptron.xls"));
		}
		if (xxx == 4) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_RandomForest.xls"));
		}
		if (xxx == 5) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_MultilayerPerceptron.xls"));
		}
		if (xxx == 6) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_AdaBoostM1.xls"));
		}
		if (xxx == 7) {
			workbook = Workbook.createWorkbook(new File(
					"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_ClassificationViaRegression.xls"));
		}
		if (xxx == 8) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_NaiveBayes.xls"));
		}
		if (xxx == 9) {
			workbook = Workbook.createWorkbook(
					new File("C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\excel\\ACTIVITY_TEST_BayesNet.xls"));
		}

		for (int k = 1; k < 5; k++) {
			count1 = 0;
			count2 = 0;
			String c = " ";
			if (k == 1) {
				c = "all";
			}
			if (k == 2) {
				c = "a";
			}
			if (k == 3) {
				c = "b";
			}
			if (k == 4) {
				c = "c";
			}
			sheet = workbook.createSheet(" " + c, 0);
			for (int i = 0; i < 20; i++) {

				Label label = new Label(0, count1, myUsers.get(i).toString(), arial10format_USER);
				sheet.addCell(label);

				label = new Label(0, count1 + 1, "TOTAL", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 2, "INCLASS", arial10format_3);
				sheet.addCell(label);

				label = new Label(0, count1 + 3, "OUTCLASS", arial10format_3);
				sheet.addCell(label);

				for (int j = 1; j < 11; j++) {
					String str = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\actTrain\\").append("act")
									.append(myUsers.get(i)).append(c).append(j).append("t").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str));
					traindata = new Instances(reader);
					reader.close();
// setting class attribute
					traindata.setClassIndex(traindata.numAttributes() - 1);
					String str2 = new StringBuilder(
							"C:\\Users\\MERT\\eclipse-workspace\\ProjectForWeka\\arff\\actTest\\").append("act")
									.append(myUsers.get(i)).append(c).append("tt").append(".arff").toString();
					reader = new BufferedReader(new FileReader(str2));
					Instances testdata = new Instances(reader);
					reader.close();
// setting class attribute
					testdata.setClassIndex(testdata.numAttributes() - 1);

// train classifier

					Classifier cls = null;
					if (xxx == 0) {
						cls = new JRip();
						cls.buildClassifier(traindata);
					}
					if (xxx == 1) {
						cls = new J48();
						cls.buildClassifier(traindata);
					}
					if (xxx == 2) {
						cls = new SMO();
						cls.buildClassifier(traindata);
					}
					if (xxx == 3) {
						cls = new VotedPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 4) {
						cls = new RandomForest();
						cls.buildClassifier(traindata);
					}
					if (xxx == 5) {
						cls = new MultilayerPerceptron();
						cls.buildClassifier(traindata);
					}
					if (xxx == 6) {
						cls = new AdaBoostM1();
						cls.buildClassifier(traindata);
					}
					if (xxx == 7) {
						cls = new ClassificationViaRegression();
						cls.buildClassifier(traindata);
					}
					if (xxx == 8) {
						cls = new NaiveBayes();
						cls.buildClassifier(traindata);
					}
					if (xxx == 9) {
						cls = new BayesNet();
						cls.buildClassifier(traindata);
					}

// evaluate classifier and print some statistics
					Evaluation eval = new Evaluation(traindata);

					eval.evaluateModel(cls, testdata);
					if (j == 10) {
						label = new Label(j, count2, myUsers.get(i).toString() + "" + j, arial10format_USER);
					} else {
						label = new Label(j, count2, myUsers.get(i).toString() + "0" + j, arial10format_USER);
					}

					sheet.addCell(label);

					Number number = new Number(j, count2 + 1, eval.pctCorrect() / 100, fourdpsFormat); // Correctly
					// classified
					// instance
					sheet.addCell(number);

					number = new Number(j, count2 + 2, eval.truePositiveRate(0), fourdpsFormat); // Inclass
					sheet.addCell(number);

					number = new Number(j, count2 + 3, eval.trueNegativeRate(0), fourdpsFormat); // Outclass
					sheet.addCell(number);

					System.out.println("CHECK TO RUN ACTIVITY TEST");
				}
				count2 = count2 + 4;
				count1 = count1 + 4;

			}
		}
		workbook.write();
		workbook.close();

	}

	public static void main(String[] args) throws Exception {
	
		int i=0;
		/*
		for(i=0;i<10;i++) {
			if(i == 5) {
				continue;
			}
			myMethod_Device_Train(i);
			myMethod_Device_Test(i);
		}
		for(i=0;i<10;i++) {
			if(i == 5) {
				continue;
			}
			myMethod_Activity_Train(i);
			myMethod_Activity_Test(i);
		}
		for(i=0;i<10;i++) {
			if(i == 5) {
				continue;
			}
			myMethod_Call_Train(i);
			myMethod_Call_Test(i);
		}
		myMethod_Device_Train(5);
		myMethod_Device_Test(5);
		
		myMethod_Activity_Train(5);
		myMethod_Activity_Test(5);
		//done
		*/
		//myMethod_Call_Train(5);
		//myMethod_Call_Test(5);
		/*
		for(i=2;i<10;i++) {
			if(i == 5) {
				continue;
			}
			myMethod_Cell_Train(i);
			myMethod_Cell_Test(i);
		}
		*/
		//myMethod_Cell_Train(5);
		myMethod_Cell_Test(5);
	}

}