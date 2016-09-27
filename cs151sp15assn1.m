%Dylan Balata
%section 005
clc
clear
close ALL

hkm=100; %max height in kilometers
hm=hkm*1000 %max height in meters
sf=25000; %starting height in feet
si=sf*12; %starting height in inches
scm=si*2.54; %starting height in centimeters
sm=scm/100 %starting height in meters
dt=hm-sm %distance traveled in meters

u=(-2*-9.81*dt)^(1/2)