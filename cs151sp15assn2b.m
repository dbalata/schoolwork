% Dylan Balata
% CS151-005
% cs151sp15assn2b
% calculating pi using probability

clear
clc
close ALL

n = input('enter number of points: '); % number of samples to take
x = rand (1,n); % x values
y = rand (1,n); % y values
dist = ((x-.5).^2+(y-.5).^2).^(1/2); % distance of point from center of circle centered at (.5,.5)
in_out = (floor(dist+.5))*-1+1; % 0 = outside of circle, 1 = inside
pi_approx = 4*((sum(in_out))/n) % approximation of pi
percent_error = abs((pi_approx-pi)/pi) % percent error

%1e4