% Dylan Balata
% CS 151-005
% Assignment 6 First
% x1,y1,x2,y2,startxdomain,endxdomain

function line =  cs151sp15assn6first(x1,y1,x2,y2,startxdomain,endxdomain)
slope = (y2-y1)/(x2-x1);
int = y1-x1*slope;
x = [startxdomain:.1:endxdomain];
y = slope.*x+int;
figure(1)
plot(x,y,'r')
hold on
plot (x2,y2,'o')