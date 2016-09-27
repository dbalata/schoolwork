% Dylan Balata
% cs151L-005
% cs151sp15assn9
% Using symbolics to determine weight load given angles

clear
clc
close all

load('equilibrium9') % loads given data file

theta = theta*(pi/180); % convert thetas from degrees to radians
syms T1 T2 T3 T4 ; % creates symbolic variables for tensions
g = -9.81; % acceleration due to gravity

eq1 = -T1*sin(theta(1))-(T4*sin(theta(4))-M*g)==0; % first given equation
eq2 = -T1*cos(theta(1))-T4*cos(theta(4))==0; % second given equation
eq3 = T2*cos(theta(1)+theta(2))+T3*cos(theta(3))==T4*cos(theta(4)); % third given equation
eq4 = T2*sin(theta(1)+theta(2))+T3*sin(theta(3))==T4*sin(theta(4)); % fourth given equation

S = solve(eq1,eq2,eq3,eq4,T1,T2,T3,T4); % solves the four given equations for the four unknown tensions

T1 = double(S.T1); % converts T1 value in strucure to double
T2 = double(S.T2); % converts T2 value in strucure to double
T3 = double(S.T3); % converts T3 value in strucure to double
T4 = double(S.T4); % converts T4 value in strucure to double

fprintf('T1 = %6.3f\nT2 = %6.3f\nT3 = %6.3f\nT4 = %6.3f\n', [T1 T2 T3 T4]'); % prints out variables with their values