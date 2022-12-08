
function feature_search(data)
data = load("/MATLAB Drive/Projects/Feature Selection/CS170_Small_Data__96.txt");

currentSet = [];

for i = 1 : size(data,1)
    disp(["On the ", int2str(i), "th level of the search tree"]);
    featureToAdd = [];
    bestAccSoFar = 0;
     for k = 1 : size(data, 2)-1;
         if isempty(intersect(currentSet, k))
             disp(["-->Considering adding ", int2str(k), "th feature..."]);
             accuracy = leaveOneOut(data, currentSet, k + 1) 

            if accuracy > bestAccSoFar
                bestAccSoFar = accuracy;
                featureToAdd = k;
            end
        end
    end
    currentSet(i) = featureToAdd;
    disp(["On level ", num2str(i), " I added feature ", num2str(featureToAdd), " to the set." ])
end
end

function accuracy = leaveOneOut(data, currentSet, featureToAdd)

numCorrect = 0;
for i = 1 : size(data, 1)
    testObj = data(i, 2:end);
    testLabel = data(i, 1);

    nearestNeighborDist = inf;
    nearestNeighborLoc = inf;

    for k = 1 : size(data, 1)
        disp(['Is ', int2str(i), ' a nearest neighbor with ', int2str(k), '?']);
        if k ~= i
            distance = sqrt(sum((testObj - data(k, 2:end)).^2));
            if distance < nearestNeighborDist
                nearestNeighborDist = distance;
                nearestNeighborLoc = k;
                nearestNeighborLabel = data(nearestNeighborLoc, 1);
            end
        end
    end

    if testLabel == nearestNeighborLabel
        numCorrect = numCorrect + 1;

    end
    accuracy = numCorrect / size(data, 1);

end
end

