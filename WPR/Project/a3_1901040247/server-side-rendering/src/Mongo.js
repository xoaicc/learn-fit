module.exports = {
    mulMongoObj: (mongooseArray) => {
        return mongooseArray.map(mongoose => mongoose.toObject());
    },
    mongoObj: (mongoose) => {
        return mongoose ? mongoose.toObject() : mongoose;
    }
}