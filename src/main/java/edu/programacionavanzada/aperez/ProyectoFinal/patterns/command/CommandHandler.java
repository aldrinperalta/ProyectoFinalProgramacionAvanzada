package edu.programacionavanzada.aperez.ProyectoFinal.patterns.command;


public interface CommandHandler<R, C extends Command<R>> {

    R handle(C command);
}