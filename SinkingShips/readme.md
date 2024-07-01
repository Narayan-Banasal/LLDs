# Sinking Ship Game

## Overview
The Sinking Ship game is a two-player strategy game where players place and target cannons on their grids. The objective is to destroy the opponent's cannons while keeping as many of your own cannons intact as possible. The player with the most surviving cannons at the end of the game wins.

## Game Setup

### Grid Size
- Player 1 chooses the size of their grid.
- Player 2 then chooses their grid size, which must be less than Player 1's grid size.

### Cannon Placement and Targeting
- Both players decide the number of cannons they can place on their grids, denoted by x and y.
- Each player manually places their cannons on their grid and specifies the target coordinates for each cannon on the opponent's grid.

## Game Mechanics

### Starting the Game
- After placing and targeting all cannons, both players click the Start button.
- All cannons on both sides are fired simultaneously.

### Cannon Firing and Targeting
- If a cannon hits a square on the opponent's grid that contains a cannon, that cannon is destroyed.
- If a cannon hits a square on the opponent's grid that does not contain a cannon, nothing happens.
- If cannons from both players are placed on the same squares and target the same squares, they will collide in the air and be destroyed due to the same trajectory.

## Winning the Game
The player with the most surviving cannons at the end of the game wins.

## Example Scenario

### Grid Size
- Player 1: 10x10
- Player 2: 8x8

### Cannon Count
- Player 1: 5 cannons
- Player 2: 3 cannons

### Cannon Placement
- Player 1 places cannons at specified coordinates and sets targets on Player 2's grid.
- Player 2 places cannons at specified coordinates and sets targets on Player 1's grid.

### Firing Phase
- Both players click the Start button.
- Cannons are fired, and hits/misses are evaluated.
- Surviving cannons are counted to determine the winner.

## Rules
- Player 2's grid size must be smaller than Player 1's grid size.
- Each player manually places their cannons and sets target coordinates.
- Cannon placement and targeting are specified by the players.
- If cannons from both players target the same square, they will collide and be destroyed.
