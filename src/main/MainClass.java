package main;

import java.io.BufferedReader;
import java.io.StringReader;

import domain.Forest;
import library.Library;
import splitWord.GetWord;

public class MainClass {
	public static void main(String[] args) throws Exception {
		/**
		 * �ʵ�Ĺ���.һ��һ���ʺ����ǲ���.���Դ��ļ���ȡ.������read��.
		 */
		String dic = "�й�\t1\tzg\n����\t2\n�й�����\t4\n����\t3\n�｡\t5\nCSDN\t6\njava\t7\njavaѧϰ\t10\n";
		Forest forest = Library.makeForest(new BufferedReader(new StringReader(dic)));

		/**
		 * ɾ��һ������
		 */
		Library.removeWord(forest, "�й�");
		/**
		 * ����һ���´�
		 */
		Library.insertWord(forest, "�й���");
		String content = "�й�����ʶ�����й������һ������.�｡������CSDN��ѧ���˺ܶ�����iteye��javaѧϰ�ʼǽ�javaeye����java123ֻ��һ����";
		GetWord udg = forest.getWord(content);

		String temp = null;
		while ((temp = udg.getFrontWords()) != null)
			System.out.println(temp + "\t\t" + udg.getParam(1) + "\t\t" + udg.getParam(2));
	}
}
