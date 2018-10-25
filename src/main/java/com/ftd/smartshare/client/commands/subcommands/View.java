package com.ftd.smartshare.client.commands.subcommands;

import com.ftd.smartshare.client.api.Api;
import com.ftd.smartshare.dto.ViewRequestDto;

import picocli.CommandLine;

@CommandLine.Command(
        description = "Views a file",
        name = "view",
        aliases = "v",
        mixinStandardHelpOptions = true
)

	public class View implements Runnable {

	    @CommandLine.Parameters(arity="1", index = "0", description = "Name of file to be viewed")
	    private String fileName;

	    @CommandLine.Parameters(arity="1", index = "1", description = "The password for the file")
	    private String password;

	    public void run() {
	        System.out.println("Viewing " + fileName);
	        ViewRequestDto viewDto = new ViewRequestDto(fileName, password);
	        Api.loadView(viewDto);
	    }

	}