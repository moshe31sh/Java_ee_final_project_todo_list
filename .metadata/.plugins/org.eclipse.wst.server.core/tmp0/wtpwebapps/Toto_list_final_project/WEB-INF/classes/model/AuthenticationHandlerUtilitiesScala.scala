

package model
import java.security.MessageDigest;
import com.sun.istack.internal.logging.Logger;

/**
 * Scala utilities object 
 * 
 */

object AuthenticationHandlerUtilitiesScala {

	val logger : Logger = Logger.getLogger(getClass);

//
///**
// * compare between 2 object , if equal returns true 
// *  @param requestUser
// * @param dataBaseUser
// * @return
// */
//
//def comperUsers(requestUser :User , dataBaseUser :User): Boolean = {
//		if (requestUser.getUserName() == dataBaseUser.getUserName() && 
//				requestUser.getUserLastName() == dataBaseUser.getUserLastName() &&
//				requestUser.getUserId() == dataBaseUser.getUserId() && 
//				requestUser.getPassword() == dataBaseUser.getPassword()){
//			logger.info("Compare successed")
//			return true;
//		}
//		return false;
//
//}


/**
 * receive user password and encrypt it
 * returns md5 string 
 * @param pass - string contain user password
 * @return - hashed password
 */
def passEncryption( pass:String): String = {
		logger.info("Encrypt password")
		var bytes :Array[Byte]  = null
		// Create MessageDigest instance for MD5
		val md = java.security.MessageDigest.getInstance("MD5")
		//Add password bytes to digest
		md.update(pass.getBytes())
		//Get the hash's bytes
		bytes = md.digest()
		//This bytes[] has bytes in decimal format;
		//Convert it to hexadecimal format
		val sb = new StringBuilder()
		var i = 0
		for(i <-0 until bytes.length){
			sb.append(Integer.toString((bytes(i) & 0xff) + 0x100, 16).substring(1))
		}  
		//Get complete hashed password in hex format
		return sb.toString()
}

}