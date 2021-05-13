package com.ss.training.w1.d3.a2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class W1D3Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//File output = new File("assets/w1/d3/a2/output.txt");
		
		W1D3Assignment2 assign = new W1D3Assignment2();
		
		FileWriter output = null;
		try {
			output = new FileWriter("assets/w1/d3/a2/output.txt", true);
			output.write(System.lineSeparator());
			output.write(System.lineSeparator());
			if(args.length >= 1) {
				output.write(args[0]);
			}else {
				assign.defaultPrompt(output);
			}
			output.close();
		}catch(IOException e) {
			e.printStackTrace();
        }

	}
	
	public void defaultPrompt(FileWriter output) throws IOException {
		defaultPrompt(output, 0, new Scanner(System.in));
	}
	
	public void defaultPrompt(FileWriter output, int timesConfirmed, Scanner s) throws IOException {
		switch(timesConfirmed) {
		case 0:
			System.out.println("No input detected. Would you like to append the default text?");
			defaultPromptConfirm(output, timesConfirmed, s);
			break;
		case 1:
			System.out.println("Are you sure about that?");
			defaultPromptConfirm(output, timesConfirmed, s);
			break;
		case 2:
			System.out.println("Are you ABSOLUTELY sure about that? It WILL involve jokes and memes.");
			defaultPromptConfirm(output, timesConfirmed, s);
			break;
		case 3:
			System.out.println("Are you ABSOLUTELY, POSITIVELY SURE about that? Because I think you aren't.");
			defaultPromptConfirm(output, timesConfirmed, s);
			break;
		case 4:
			System.out.println("Okay, but don't say I didn't warn you.");
			System.out.println("Proceed.");
			if(!s.nextLine().equalsIgnoreCase("y")) {
				System.out.println("It is too late to cancel.");
			}
			defaultText(output);
			break;
		default:
			timesConfirmed = 4;
			defaultPrompt(output, timesConfirmed, s);
			break;
		}
	}
	
	public void defaultPromptConfirm(FileWriter output, int timesConfirmed, Scanner s) throws IOException {
		System.out.println("Type Y to proceed, and anything else to cancel.");
		if(s.nextLine().equalsIgnoreCase("y")) {
			timesConfirmed++;
			defaultPrompt(output, timesConfirmed, s);
		}else {
			System.out.println("Okay, cancelling file append.");
		}
	}
	
	
	public void defaultText(FileWriter output) throws IOException {
		Random random = new Random();
		int i = random.nextInt(3)+1;
		switch(i) {
		case 0:
		default:
			portal2Text(output);
			break;
		case 1:
			beeMovieText(output);
			break;
		case 2:
			rickAndMortyCopypastaText(output);
			break;
		}
	}
	
	public void portal2Text(FileWriter output) throws IOException {
		output.write("\"Wow, this is coo-hool! And check this out, I'm a bloody genius now!\"");
		output.write(System.lineSeparator());
		output.write("\"Estas usando este software de traduccion de forma incorrecta. por favor, consulta el manual\"");
		output.write(System.lineSeparator());
		output.write("\"I don't even know what I just said, but I can find out!\"");
	}
	
	public void beeMovieText(FileWriter output) throws IOException {
		output.write("According to all known laws of aviation, there is no way a bee should be able to fly. Its wings are too small to get its fat little body off the ground. The bee, of course, flies anyway, because bees don't care what humans think is impossible. \"Yellow, black. Yellow, black. Yellow, black. Yellow, black. Ooh, black and yellow! Let's shake it up a li-");
	}
	
	public void rickAndMortyCopypastaText(FileWriter output) throws IOException {
		output.write("To be fair, you have to have a very high IQ to understand Rick and Morty. The humor is extremely subtle, and without a solid grasp of theoretical physics most of the jokes will go over a typical viewer's head. There's also Rick's nihilistic outlook, which is deftly woven into his characterisation - his personal philosophy draws heavily from Narodnaya Volya literature, for instance. The fans understand this stuff; they have the intellectual capacity to truly appreciate the depths of these jokes, to realize that they're not just funny- they say something deep about LIFE. As a consequence people who dislike Rick and Morty truly ARE idiots- of course they wouldn't appreciate, for instance, the humour in Rick's existencial catchphrase \"Wubba Lubba Dub Dub,\" which itself is a cryptic reference to Turgenev's Russian epic Fathers and Sons I'm smirking right now just imagining one of those addlepated simpletons scratching their heads in confusion as Dan Harmon's genius unfolds itself on their television screens. What fools... how I pity them. 😂 And yes by the way, I DO have a Rick and Morty tattoo. And no, you cannot see it. It's for the ladies' eyes only- And even they have to demonstrate that they're within 5 IQ points of my own (preferably lower) beforehand.");
	}

}
