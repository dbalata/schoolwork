% Dylan Balata
% CS 151-005
% Assignment 6 First
% Determines line portion

function line =  cs151sp15assn6first(pt1,pt2,startxdomain,endxdomain)
slope = (pt2(2)-pt1(2))/(pt2(1)-pt1(1)); % Slope of the lines
int = pt1(2)-pt1(1)*slope; % Y intercept
x = [startxdomain:.1:endxdomain]; % x values of line
y = slope.*x+int; % y values of line
figure(1) 
plot(x,y,'r') % plotting the line