# BlumBlum

(15 points) You are going to develop a program that uses pseudorandom bits to encrypt text.

•	Implement the Blum-Blum-Shub PRNG as specified in the textbook in section 5.1
(Pseudorandom bit generation) in a method that returns a list of bits.
The method takes the parameters p, q, x, and count. The first three are as specified in the BBS algorithm.
The count parameter specifies how many bits to generate.

•	Write a method that takes as a parameter a list of bits as
a plaintext string and a list of key bits and that returns a list of ciphertext bits.

•	Write a main method or main program that reads in a textfile called bbstext.txt containing 4 lines:

o	value for p
o	value for q
o	value for x
o	plaintext bit string

•	It then uses the above methods to encrypt that plaintext string and then prints the ciphertext bit string.
