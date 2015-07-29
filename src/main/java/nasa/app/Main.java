package nasa.app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import nasa.exception.FileNotFoundException;
import nasa.model.Direction;
import nasa.model.Position;
import nasa.model.Signal;
import nasa.panel.Nasa;

public class Main {

	private static final String	FILE_NOT_FOUND		= "Arquivo invalido ou nao encontrado.";
	private static boolean		firstLine			= true;
	private static boolean		roverInformation	= true;

	public Main() {
	}

	/**
	 * Metodo principal do programa. execucao devera ser feita por linha de comando, informando o caminho do arquivo a ser processado, 
	 * conforme o exemplo: 
	 * 		'java -jar nasaproject.jar d:\input.txt' 
	 * - O Arquivo informado devera conter as informacoes do problema, conforme exemplo abaixo, a ser executada pelo programa: 
	 * 		input.txt 
	 * 			5 5 
	 * 			1 2 N 
	 * 			LMLMLMLMM
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		Position initialPosition = new Position(3, 3);
		Direction initialDirection = new Direction(Direction.EAST);

		String filePath = args[0];

		File file = new File(filePath);

		if (!file.exists() && !file.isFile()) {
			throw new FileNotFoundException(FILE_NOT_FOUND);
		}

		FileReader reader = new FileReader(file);
		BufferedReader buffer = new BufferedReader(reader);
		Nasa nasa = null;

		while (buffer.ready()) {
			String line = buffer.readLine();

			if (firstLine) {
				nasa = new Nasa(readBouds(line));
				firstLine = false;
			} else if (roverInformation) {
				String[] roverInformations = readRoverInformation(line);
				initialPosition = new Position(Integer.valueOf(roverInformations[0]), Integer.valueOf(roverInformations[1]));
				initialDirection = new Direction(roverInformations[2].charAt(0));

				roverInformation = false;
			} else {
				Signal signal = new Signal(line);
				nasa.sendCommandToRover(initialPosition, initialDirection, signal);

				System.out.println(nasa.getResults());

				roverInformation = true;
			}

		}

		buffer.close();
	}

	/**
	 * Le as informacoes do terreno
	 * 
	 * @param line
	 * @return
	 */
	private static Position readBouds(String line) {
		String[] bounds = line.split(" ");
		return new Position(Integer.valueOf(bounds[0]), Integer.valueOf(bounds[1]));
	}

	/**
	 * Le as informacoes do Rover
	 * 
	 * @param line
	 * @return
	 */
	private static String[] readRoverInformation(String line) {
		String[] roverInformations = line.split(" ");
		return roverInformations;
	}
}
