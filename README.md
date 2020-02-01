# Simple Logo (SLogo)

## Introduction
[Logo](https://en.wikipedia.org/wiki/Logo_%28programming_language%29) is a
general-purpose language best known for its use in education; for students new
to programming, Logo acts as a soft introduction to basic concepts like
commands, loops and conditionals.

This project is an exercise in reproducing the fundamental functionalities of a
Logo parser and its signature companion turtle manipulation interface.

### Implemented LOGO Concepts
The SLogo lexicon is a subset of the concepts covered by Logo.

Implemented SLogo concepts and commands:
- Constants
- fd
- bk
- lt
- rt
- set
- goto

## Getting Started

Get started by running [Runner.java](main/Runner.java). See `examples/` for
small runnable command snippets.

## Architecture

This project follows the MVC paradigm, with the view (V in MVC) in `src/gui/`
and model (M) and controller (C) primarily in `src/backend`.

Commands, found in `src/commands`, are separated out as subclasses of command
archetypes (`booleanCommands`, `mathCommands`, `turtleCommands`, etc). The
command architecture was built to be easily extensible. Please contact the repo
owner if you find command creation to be nontrivial.
