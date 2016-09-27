% Dylan Balata
% CS151-05
% cs151sp15assn2a.m
% calculating pi using inscribed polygons

clear
clc
close ALL

n = [4 8 16 32 64 128] % # of sides inscribed in circle
theta = [360./n]; % value of theta corresponding with sides
s = [(2-2*cosd(theta)).^(1/2)]; % side lengths
p = [n.*s]; % perimeters of polygons
pi_approx = [p./2] % approximation of pi
percent_error = [abs(pi_approx-pi)./pi] % percent error
plot(n, percent_error) % plot

