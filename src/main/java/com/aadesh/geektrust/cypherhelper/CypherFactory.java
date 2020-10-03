package com.aadesh.geektrust.cypherhelper;

  /**
  * DESCRIPTION - A Factory that returns the instance, based on the algorithm name provided.
  * 
  * @param algorithm - This is the name of algorithm, that is requested to be used for encryption/decryption.
  * 
  * @throws ClassNotFoundException - Cypher algorithm not supported.
  * @return instance of algorithm rquested.
  *
  * @author Aadesh Singhai
  * @version 0.0.1
  */

public enum CypherFactory{

  INSTANCE;
    
  /**
   * 
   * @param algorithm - algo requested to be used.
   * 
   * @return - instance of the algo requested.
   * @throws ClassNotFoundException - algorithm requested is not supported.
   */
  public Cypher getEncrypt(String algorithm) throws ClassNotFoundException {
    switch (algorithm.toUpperCase()) {
      case "SEASAR":
        return new SeasarCypher();
      default:
        throw new ClassNotFoundException(algorithm + "cipher algorithm not Supported");
    }
  }
}
