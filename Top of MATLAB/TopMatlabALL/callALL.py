"""
Created on Sat Dec 15 16:44:44 2018

@author: Mert PEHLIVANCIK
"""

import glob
import os
# Set folder:
folder = r"E:\COMPUTER ENGINEERIG\4.Sınıf\ArtificalNeuralNetwork\MatlabFile\Train"
# Get filepaths for all files which end with ".txt"
allFiles = glob.glob(folder + "/call*all*.data")

# iterate for each file path in the list
for fp in allFiles:
    # Open the file in read mode
    with open(fp, "r+") as f:
        # We read the existing text from file in READ mode
        a = f.read()
        name = os.path.splitext(fp)[0]
        name = name[71:]
        print(name)
    # Now writing into the file with the prepend line + old file data
    with open(fp, "w+") as f:
        f.write("9 \n")
        f.write("#n \t")
        f.write("phonenumber_oid \t")
        f.write("dd \t")
        f.write("md \t")
        f.write("wdu \t")
        f.write("cidu \t")
        f.write("descid \t")
        f.write("dirid \t")
        f.write("stime \t")
        f.write("duration \t\n" +a)

