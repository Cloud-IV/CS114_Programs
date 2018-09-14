# CS114_Programs
Pertinent programs and resources created for college course dealing with data structures and algorithms.

The Queue class is utilized in both GUIQueue.java and Animation.java. It creates the basis for a first-in-first-out (FIFO) circular queue.

GUIQueue.java showcases an implementation of a FIFO-based circular queue in the form of a simple GUI. One can add any number of entries
into the queue, see what entry would be removed next using "Peek", remove any number of entries from the queue, and see how many entries
are currently in the queue.

Animation.java is modified from a given graphical program where a spaceship is able to shoot "missiles" on a scrolling background by utilizing a Sprite class within the program (allows images to be used in the program, such as the background and spaceship [not included]). 
Originally, the given program only allowed the spaceship to shoot one missile at a time. I modified the program and implemented a
FIFO-based circular queue so the spaceship could shoot any number of missiles (up to a limit), with each missile's position and velocity
being recalculated each time a new missle was introduced into the queue.

BinarySearchTree.java is an implementation of a binary search tree (BST) built from the ground-up, and includes some manipulations of a
BST, such as traversing the tree, finding the deepest node in the tree, and cloning the tree.
