import string

cipher_text = input("Enter ciphertext: ")
frequency = {}
for ch in cipher_text:
    if ch in frequency :
        frequency [ch] +=1
    else:
        frequency[ch] = 1
dict
print("frequency count: ")
print(frequency)

key= input("Guess a key: ")
alphabet = string.ascii_letters

cipher = {}
decrypt = []


cipher = list(cipher_text)

for ch in cipher:
    if (ch in alphabet):
      decrypt.append(alphabet[ch].upper())
    else:
      decrypt.append(ch)
        
decrypt = ''.join(decrypt)
print("Decrypted cipher: ",decrypt)